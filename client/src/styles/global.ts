import { createGlobalStyle } from 'styled-components';

export default createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    outline: 0;
    box-sizing: border-box;
  }

  html, body, #root {
  }

  body {
    font-size: 16px;
    font-family: 'Roboto', sans-serif;
    background-color: #fafafa;
    color: #333;
    -webkit-font-smoothing: antialiased !important;

    a {
      color: #333;
    }
  }

  button {
    font-size: 16px;
    font-family: 'Roboto', sans-serif;
    -webkit-font-smoothing: antialiased !important;
  }

`;