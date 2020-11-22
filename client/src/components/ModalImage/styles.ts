import styled from 'styled-components';

export const Container = styled.div`
  h2 {
    font-size: 22px;

    font-weight: 400;
  }

  h4 {
    margin-bottom: 8px;

    font-size: 16px;

    font-weight: 400;
  }

  p {
    color: #33444d;

    font-weight: 300;
  }

  button {
    background: none;
    border: none;

    font-size: 14px;

    margin-top: 8px;

    cursor: pointer;

    color: #0091ce;
  }
`;

export const LineSeparator = styled.div`
  border-top: 1px solid #ecebed;

  width: 100%;
  height: 2px;

  margin-top: 18px;
`;

export const Content = styled.textarea`
  margin-top: 18px;

  width: 100%;

  min-width: 100%;
  max-width: 100%;
  min-height: 320px;
  max-height: 700px;

  border-radius: 4px;

  background: #f5f5f5;

  border: 1px solid #ecebed;
  padding: 8px 5px;

  line-height: 20px;

  font-family: 'Open Sans', sans-serif;
`;
