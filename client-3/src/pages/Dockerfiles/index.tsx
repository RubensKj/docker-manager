import React, { useEffect, useState } from 'react';

// Interface
import ModalImage, { Image } from '../../components/ModalImage';

// Assets
import LogoContainer from '../../assets/Logo/docker_file.png';

// Components
import ContainerItem from '../../components/ContainerItem';

// Styles
import { Container, Header, List } from './styles';

const Dockerfiles: React.FC = () => {
  const [images, setImages] = useState<Image[]>([] as Image[]);

  const [isOpen, setIsOpen] = useState<boolean>(false);
  const [selectedImage, setSelectedImage] = useState<Image>({} as Image);

  useEffect(() => {
    const response = [
      {
        id: 1,
        filename: 'emissao-rda.dockerfile',
        imageName: 'emissao-rda',
        content: 'version: 3.8',
        type: 'JAVA',
      },
      {
        id: 2,
        filename: 'recebimento-rda.dockerfile',
        imageName: 'recebimento-rda',
        content: 'version: 3.8',
        type: 'JAVA',
      },
      {
        id: 3,
        filename: 'eureka-rda.dockerfile',
        imageName: 'eureka-rda',
        content: 'version: 3.8\nFROM node:latest\nMAINTAINER RubensKj\nENV NODE_ENV=development\nCOPY . /var/www\nWORKDIR /var/www\nRUN npm install \nENTRYPOINT ["npm", "start"]\nEXPOSE 3000',
        type: 'JAVA',
      }
    ]

    setImages(response);
  }, []);

  function toggleImageModal(image: Image): void {
    toggleModal();
    setSelectedImage(image);
  }

  function toggleModal() {
    setIsOpen(!isOpen);
  }

  return (
    <>
      <ModalImage isOpen={isOpen} setIsOpen={toggleModal} image={selectedImage} />

      <Container>
        <Header>
          <h1>Images</h1>
        </Header>
        <List>
          {images !== null && images.length ? 
            images.map(image  => (
              <ContainerItem key={image.id} onClick={toggleImageModal} icon={LogoContainer} image={image} />
            )) : (
              <p>Sorry, You haven't created any dockerfile yet. Create one in the home page..</p>
          )}
        </List>
      </Container>
    </>
  );
}

export default Dockerfiles;