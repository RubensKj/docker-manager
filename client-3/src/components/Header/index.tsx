import React, { useCallback } from 'react';

import { useModal } from '../../contexts/ModalContext';

// Assets
import LogoIcon from '../../assets/Logo/docker_logo.png';
import HomeIcon from '../../assets/HomeIcon';
import ComposersIcon from '../../assets/ComposersIcon';

// Styles
import { Container, Wrapper, Logo, Menu, Actions } from './styles';
import IconPlus from '../../assets/IconPlus';

const Header: React.FC = () => {
  const { toggleModal } = useModal();

  const createDockerFile = useCallback(() => {
    toggleModal();
  }, [toggleModal]);

  return (
    <Container>
      <Wrapper>
        <Logo>
          <img srcSet={LogoIcon} alt="Logo" />
          <h1>Docker Manager</h1>
        </Logo>
        <Menu>
          <ul>
            <a href="/">
              <HomeIcon size={16} />
              <li>Home</li>
            </a>
            <a href="/dockerfiles">
              <ComposersIcon size={16} />
              <li>Dockerfiles</li>
            </a>
          </ul>
        </Menu>
        <Actions>
          <button onClick={createDockerFile}>
            <IconPlus size={16} />
          </button>
        </Actions>
      </Wrapper>
    </Container>
  );
}

export default Header;