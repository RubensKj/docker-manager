import React, { useState } from 'react';

import { useModal } from '../../contexts/ModalContext';

// Icons
import Logo from '../../assets/Logo/docker_file.png';
import DockerComposeLogo from '../../assets/Logo/docker_compose.png';
import DockerContainers from '../../assets/Logo/containers.png';

// Components
import FeatureCardButton from '../../components/FeatureCardButton';
import FeatureCard from '../../components/FeatureCard';
import ModalDockerComposeCreate from '../../components/ModalDockerComposeCreate';

// Styles
import { Container, Header, Actions } from './styles';

const Main: React.FC = () => {
  const [isOpen, setIsOpen] = useState<boolean>(false);

  const { toggleModal } = useModal();

  function toggleModalDockerCompose(): void {
    setIsOpen(!isOpen);
  }

  return (
    <>
      <ModalDockerComposeCreate isOpen={isOpen} setIsOpen={toggleModalDockerCompose} />

      <Container>
        <Header>
          <h1>Features</h1>
        </Header>
        <Actions>
          <FeatureCardButton icon={Logo} title="Create Dockerfile" description="Create Dockerfile based in the language of your project." action={toggleModal} />
          <FeatureCardButton icon={DockerComposeLogo} title="Create Compose" description="Create docker-compose file using the dockerfiles that you've created." action={toggleModalDockerCompose} />
          <FeatureCard icon={DockerContainers} title="Dockerfiles" description="See all your created dockerfiles." redirectPath="/dockerfiles" />
        </Actions>
      </Container>
    </>
  );
}

export default Main;