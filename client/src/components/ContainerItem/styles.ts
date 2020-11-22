import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  align-items: center;

  background: #fff;

  padding: 18px 28px;

  border-radius: 4px;

  box-shadow: 0 3px 6px rgba(11,33,74,0.09), 0 -2px 2px rgba(11,33,74,0.03);

  cursor: pointer;

  img {
    max-width: 78px;
    max-height: 78px;
  }

  transition: transform 150ms ease-in-out;

  :hover {
    transform: scale(1.01);
  }
`;

export const Content = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;

  margin-left: 24px;

  h2 {
    margin-bottom: 8px;

    font-size: 20px;

    font-weight: 400;
  }

  p {
    text-align: left !important;
    color: #33444d;

    font-weight: 300;
  }
`;
