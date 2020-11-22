import React, { useCallback, useEffect, useRef, useState } from 'react';
import * as Yup from 'yup';

// Interface
import { IModalProps } from '../ModalInterface';
import { FormHandles } from '@unform/core';

// Components
import Modal from '../Modal';
import Input from '../Input';
import AsyncSelect from '../AsyncSelect';

// Services
import api from '../../services/api';

// Styles
import { Container, FormArea } from './styles';
import { Image } from '../ModalImage';

interface LanguageValue {
  label: string;
  value: string;
}

const ModalDockerFileCreate: React.FC<IModalProps> = ({ isOpen, setIsOpen }) => {
  const formRef = useRef<FormHandles>(null);
  const [languages, setLanguages] = useState<LanguageValue[]>([] as LanguageValue[]);

  useEffect(() => {
    api.get('/types').then(response => {
      console.log(response.data)
      setLanguages(response.data);
    });
  }, []);

  const handleSubmit = useCallback(
    async (data: Image) => {
      console.log(data)
      try {
        const schema = Yup.object().shape({
          name: Yup.string()
            .min(3, 'Field should contains at least 3 caracters.')
            .max(50, 'Field is more than 50 caracters.')
            .required('Field is required.'),
          fileName: Yup.string()
            .min(3, 'Field should contains at least 3 caracters.')
            .max(50, 'Field is more than 50 caracters.')
            .required('Field is required.'),
          type: Yup.string().required('Field is required.'),
        });

        await schema.validate(data, {
          abortEarly: false,
        });
      } catch (error) {
        const errorMessages = {};

        if (error instanceof Yup.ValidationError) {

          error.inner.forEach(err => {
            errorMessages[err.path] = err.message;
          });

          return formRef.current?.setErrors(errorMessages);
        }
      }

      formRef.current?.setErrors({});

      api.post('/image', data).then(response => {
        console.log(response)
        formRef.current?.reset();
        setIsOpen();
      });
    }, [setIsOpen]
  );

  const filterColors = (inputValue: string) => {
    return languages.filter(i =>
      i.label.toLowerCase().includes(inputValue.toLowerCase())
    );
  };

  const loadOptions = (inputValue, callback) => {
    setTimeout(() => {
      callback(filterColors(inputValue));
    }, 1000);
  };

  return (
    <Modal isOpen={isOpen} setIsOpen={setIsOpen}>
      <Container>
        <h2>Create Dockerfile</h2>
        <p>Fill the fields below in order to create your Dockerfile..</p>
        <FormArea ref={formRef} onSubmit={handleSubmit}>
          <h3>Image name</h3>
          <Input name="name" />
          <h3>Dockerfile name</h3>
          <Input name="fileName" />
          <h3>Language</h3>
          <AsyncSelect className="async-select" name="type" defaultOptions={languages} noOptionsMessage={() => 'Type the language'} loadOptions={loadOptions} />
          <button>
            <span>Create Dockerfile</span>
          </button>
        </FormArea>
      </Container>
    </Modal>
  );
}

export default ModalDockerFileCreate;