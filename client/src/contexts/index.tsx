import React from 'react';

// Providers
import { ModalProvider } from './ModalContext';

const AppProvider: React.FC = ({ children }) => {
  return (
    <ModalProvider>
      {children}
    </ModalProvider>
  );
}

export default AppProvider;