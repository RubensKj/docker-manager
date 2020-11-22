import React, { useEffect, useState } from 'react';

import ReactModal from 'react-modal';

interface IModalProps {
  children: any;
  width?: string;
  isOpen: boolean;
  setIsOpen: () => void;
}

const Modal: React.FC<IModalProps> = ({ children, width = '520px', isOpen, setIsOpen }) => {
  const [modalStatus, setModalStatus] = useState(isOpen);

  useEffect(() => {
    setModalStatus(isOpen);
  }, [isOpen]);

  return (
    <ReactModal
      shouldCloseOnOverlayClick={!false}
      onRequestClose={setIsOpen}
      isOpen={modalStatus}
      ariaHideApp={false}
      style={{
        content: {
          top: '50%',
          left: '50%',
          right: 'auto',
          bottom: 'auto',
          marginRight: '-50%',
          transform: 'translate(-50%, -50%)',
          background: '#FFFFFF',
          borderRadius: '4px',
          maxWidth: width,
          width: '100%',
          border: 'none',
          boxShadow: '0px 8px 19px 2px rgba(0,0,0,0.1)',
          zIndex: -2,
          overflow: 'visible'
        },
        overlay: {
          backgroundColor: 'rgba(18, 18, 20, 0.18)',
        },
      }}
    >
      {children}
    </ReactModal>
  );
}

export default Modal;