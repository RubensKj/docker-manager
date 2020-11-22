import styled from 'styled-components';

export const Container = styled.div`
  max-width: 1370px;

  margin: 0 auto;
`;

export const Header = styled.header`
  display: flex;
  justify-content: center;
  align-items: center;

  margin-bottom: 25px;

  h1 {
    font-size: 22px;

    font-weight: 400;

    margin-top: 55px;
  }
`;

export const Actions = styled.div`
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;

  gap: 18px;

  max-width: 1078px;
  width: 100%;

  padding: 0 15px;

  margin: 0 auto;

  transition: 0.2s grid-template-columns;

  @media only screen and (max-width: 850px) {
    grid-template-columns: 1fr 1fr;
  }

  @media only screen and (max-width: 670px) {
    grid-template-columns: 1fr;
  }
`;