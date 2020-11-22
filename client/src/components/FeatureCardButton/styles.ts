import styled from 'styled-components';

export const Container = styled.div`
  padding: 24px 36px;

  border-radius: 4px;

  background: #fff;
  box-shadow: 0 3px 6px rgba(11,33,74,0.09), 0 -2px 2px rgba(11,33,74,0.03);

  cursor: pointer;

  text-decoration: none;

  transition: transform 150ms ease-in-out;

  :hover {
    transform: scale(1.01);
  }

  img {
    max-width: 78px;
    max-height: 78px;
  }

  h2 {
    margin-top: 15px;
    margin-bottom: 8px;

    font-size: 22px;

    font-weight: 400;
  }

  p {
    color: #33444d;

    font-weight: 300;
  }
`;
