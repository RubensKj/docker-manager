import React, { useRef } from 'react';

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
  fileName: string;
  name: string;
  contentDockerFile: string;
  contentDockerCompose: string;
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
        <h2>{image.name && image.name.toUpperCase()}</h2>
        <h4>Image type: {image.type}</h4>
        <p>{image.fileName}</p>
        <LineSeparator />
        <Content ref={ref} defaultValue={image.contentDockerFile}></Content>
        <button onClick={copyToClipBoard}>Copy to the clipboard</button>
      </Container>
    </Modal>
  );
}

export default ModalImage;