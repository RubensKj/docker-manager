import React, { useState, createContext, useContext } from 'react';

// Components
import ModalDockerFileCreate from '../../components/ModalDockerFileCreate';

export interface IModalContext {
  isOpen: boolean;
  toggleModal(): void;
}

const ModalContext = createContext<IModalContext>({} as IModalContext);

export const ModalProvider: React.FC = ({ children }) => {
  const [isOpen, setIsOpen] = useState<boolean>(false);

  function toggleModal() {
    setIsOpen(!isOpen);
  }

  return (
    <ModalContext.Provider value={{toggleModal, isOpen}}>
      <ModalDockerFileCreate isOpen={isOpen} setIsOpen={toggleModal} />

      {children}
    </ModalContext.Provider>
  );
}

export function useModal() {
  const context = useContext(ModalContext);

  return context;
};