import React from 'react';

// Interface
import { Image } from '../ModalImage';

// Styles
import { Container, Content } from './styles';

interface ContainerProps {
  icon: string;
  image: Image;
  onClick: (image: Image) => void;
}

const ContainerItem: React.FC<ContainerProps> = ({ icon, image, onClick }) => {
  return (
    <Container onClick={() => onClick(image)}>
      <img srcSet={icon} alt={image.name} />
      <Content>
        <h2>{image.name}</h2>
        <p>type: {image.type}</p>
      </Content>
    </Container>
  );
}

export default ContainerItem;