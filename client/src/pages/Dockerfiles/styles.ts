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

export const List = styled.div`
  display: grid;
  grid-template-columns: 1fr;

  gap: 18px;

  max-width: 1078px;
  width: 100%;

  margin: 0 auto;

  padding: 0 15px;

  p {
    text-align: center;
  }
`;