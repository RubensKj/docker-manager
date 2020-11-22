import React, {
  InputHTMLAttributes,
  useEffect,
  useRef,
  useState,
  useCallback,
} from 'react';

// import { IconBaseProps } from 'react-icons';
import { useField } from '@unform/core';

import { Container, ErrorArea } from './styles';

interface IInputProps extends InputHTMLAttributes<HTMLInputElement> {
  name: string;
  borderColor?: string;
  // icon?: React.ComponentType<IconBaseProps>;
}

// icon: Icon

const Input: React.FC<IInputProps> = ({ name, borderColor, ...rest }) => {
  const inputRef = useRef<HTMLInputElement>(null);

  const [isFocused, setIsFocused] = useState(false);
  const [isFilled, setIsFilled] = useState(false);

  const { fieldName, defaultValue, registerField, error } = useField(name);

  const handleInputFocus = useCallback(() => {
    setIsFocused(true);
  }, []);

  const handleInputBlur = useCallback(() => {
    setIsFocused(false);

    setIsFilled(!!inputRef.current?.value);
  }, []);

  useEffect(() => {
    registerField({
      name: fieldName,
      ref: inputRef.current,
      path: 'value',
    });
  }, [fieldName, registerField]);

  return (
    <>
      {error && <ErrorArea><span>{error}</span></ErrorArea>}
      <Container isFilled={isFilled} isFocused={isFocused} borderColor={borderColor}>
        {/* {Icon && <Icon size={20} />} */}

        <input
          onFocus={handleInputFocus}
          onBlur={handleInputBlur}
          defaultValue={defaultValue}
          ref={inputRef}
          {...rest}
        />
      </Container>
    </>
  );
};

export default Input;