import React, { useCallback, useEffect, useRef, useState } from 'react';
import * as Yup from 'yup';
import { FormHandles } from '@unform/core';

// Interfaces
import { IModalProps } from '../ModalInterface';
import { DockerfileEntity } from '../ModalDockerFileCreate';

// Components
import Modal from '../Modal';
import Input from '../Input';
import AsyncSelect from '../AsyncSelect';

// Styles
import { Container, FormArea } from './styles';

interface DockerImagesCompose {
  filename: string;
  images: DockerfileEntity[];
}

interface Options {
  label: string;
  value: number;
}

const ModalDockerComposeCreate: React.FC<IModalProps> = ({ isOpen, setIsOpen }) => {
  const formRef = useRef<FormHandles>(null);
  const [options, setOptions] = useState<Options[]>([] as Options[]);

  useEffect(() => {
    const response = [
      {
        id: 1,
        name: 'emissao-rda.dockerfile',
        type: 'JAVA'
      },
      {
        id: 2,
        name: 'node.dockerfile',
        type: 'Node'
      },
      {
        id: 3,
        name: 'eureka-rda.dockerfile',
        type: 'JAVA'
      },
      {
        id: 4,
        name: 'recebimento-rda.dockerfile',
        type: 'JAVA'
      }
    ]

    setOptions(response.map(image => (
      {
        value: image.id,
        label: image.name
      }
    )));
  }, []);

  const handleSubmit = useCallback(
    async (data: DockerImagesCompose) => {
      console.log(data)
      try {
        const schema = Yup.object().shape({
          filename: Yup.string()
            .min(3, 'Field should contains at least 3 caracters.')
            .max(50, 'Field is more than 50 caracters.')
            .required('Field is required.'),
          images: Yup.array()
            .min(1, "Field needs at least one image.")
            .required('Field is required.'),
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

      // API INTEGRATION HERE
      // ...
    },
    [],
  );

  const filterColors = (inputValue: string) => {
    return options.filter(i =>
      i.label.toLowerCase().includes(inputValue.toLowerCase())
    );
  };

  const loadOptions = (inputValue, callback) => {
    setTimeout(() => {
      callback(filterColors(inputValue));
    }, 1000);
  };

  return (
    <Modal isOpen={isOpen} setIsOpen={setIsOpen} width="525px">
      <Container>
        <h2>Create Docker compose yml</h2>
        <p>Select some images to build the yml (The select will be the order)</p>
        <FormArea ref={formRef} onSubmit={handleSubmit}>
          <h3>Docker compose file name</h3>
          <Input name="filename" />
          <h3>Images</h3>
          <AsyncSelect className="async-select" name="images" isMulti={true} defaultOptions={options} noOptionsMessage={() => 'Type the image name'} loadOptions={loadOptions} />
          <button>
            <span>Create yml</span>
          </button>
        </FormArea>
      </Container>
    </Modal>
  );
}

export default ModalDockerComposeCreate;