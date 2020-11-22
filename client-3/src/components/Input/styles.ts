import styled, { css } from 'styled-components';

interface IContainerProps {
  isFocused: boolean;
  isFilled: boolean;
  borderColor?: string;
}

export const Container = styled.div<IContainerProps>`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  width: 100%;
  margin: 0 auto;

  border-radius: 2px;
  border: 2px solid ${props => props.borderColor ? props.borderColor : '#e8eaeb'};
  margin-bottom: 8px;

  ${props =>
    props.isFocused &&
    css`
      color: #45a9eb;
      border-color: #45a9eb;
    `}

  ${props =>
    props.isFilled &&
    css`
      color: #45a9eb;
    `}

  input {
    padding: 5px 8px;
    width: 100%;
    height: 32px;

    background: transparent;
    border: none;

    color: #555;

    font: 16px 'Poppins', sans-serif;

    &::placeholder {
      color: #b7b7cc;
    }
  }

  svg {
    margin-right: 16px;
  }
`;

export const ErrorArea = styled.div`
  width: 100%;
  span {
    font: 16px 'Poppins', sans-serif;
    color: #d84945 !important;
  }
`;