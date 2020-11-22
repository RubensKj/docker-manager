import React, { useEffect, useState } from 'react';

// Interface
import ModalImage, { Image } from '../../components/ModalImage';

// Assets
import LogoContainer from '../../assets/Logo/docker_file.png';

// Components
import ContainerItem from '../../components/ContainerItem';

// Service
import api from '../../services/api';

// Styles
import { Container, Header, List } from './styles';

const Dockerfiles: React.FC = () => {
  const [images, setImages] = useState<Image[]>([] as Image[]);

  const [isOpen, setIsOpen] = useState<boolean>(false);
  const [selectedImage, setSelectedImage] = useState<Image>({} as Image);

  useEffect(() => {
    api.get('/image').then(response => {
      console.log(response)
      setImages(response.data);
    });

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