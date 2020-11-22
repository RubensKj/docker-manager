import React, { TextareaHTMLAttributes, useRef } from 'react';

// Interface
import { IModalProps } from '../ModalInterface';

// Components
import Modal from '../Modal';


// Styles
import { Container, LineSeparator, Content } from './styles';

interface IModalImageProps extends IModalProps {
  image: Image;
}

export interface Image {
  id: number;
  filename: string;
  imageName: string;
  content: string;
  type: string;
}

const ModalImage: React.FC<IModalImageProps> = ({ isOpen, setIsOpen, image }) => {

  const ref = useRef<HTMLTextAreaElement>(null);

  function copyToClipBoard() {
    ref.current?.select();
    ref.current?.setSelectionRange(0, 999999);

    document.execCommand("copy");

    ref.current?.setSelectionRange(0, 0);
  }

  return (
    <Modal isOpen={isOpen} setIsOpen={setIsOpen} width="768px">
      <Container>
        <h2>{image.imageName && image.imageName.toUpperCase()}</h2>
        <h4>Image type: {image.type}</h4>
        <p>{image.filename}</p>
        <LineSeparator />
        <Content ref={ref}>{image.content}</Content>
        <button onClick={copyToClipBoard}>Copy to the clipboard</button>
      </Container>
    </Modal>
  );
}

export default ModalImage;