import styled from 'styled-components';
import { Form as Unform } from '@unform/web';

export const Container = styled.div`
  h2 {
    margin-bottom: 8px;

    font-size: 22px;

    font-weight: 400;
  }

  p {
    color: #33444d;

    font-weight: 300;
  }

  .async-select {
    height: 34px;
  }
`;

export const FormArea = styled(Unform)`
  display: flex;
  flex-direction: column;
  justify-content: center;

  width: 100%;

  margin-top: 20px;
  padding: 5px 15px;

  h3 {
    margin-bottom: 8px;

    font-size: 16px;

    font-weight: 400;
  }

  button {
    margin-top: 24px;

    background: #45a9eb;
    border-radius: 4px;
    border: none;

    height: 38px;

    color: #fff;

    font-weight: 400;

    box-shadow: 0 3px 6px rgba(11,33,74,0.09), 0 -2px 2px rgba(11,33,74,0.03);

    cursor: pointer;

    transition: 0.2s transform;

    :hover {
      transform: translateY(-2px);
    }
  }
`;