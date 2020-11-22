import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;

  width: 100%;

  height: 58px;

  padding: 0 15px;

  border-bottom: 1px solid #ecebed;

  background: #fff;
`;

export const Wrapper = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  max-width: 1440px;
  width: 100%;
  height: 100%;
`;

export const Logo = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  img {
    max-width: 42px;
    max-height: 42px;
  }

  h1 {
    font-size: 18px;

    font-weight: 500;

    color: #0091ce;

    margin-left: 8px;
  }
`;

export const Menu = styled.nav`
  display: flex;
  justify-content: center;
  align-items: center;

  width: 68%;
  height: 100%;

  ul {
    display: grid;
    justify-content: center;
    align-items: center;

    grid-template-columns: 1fr 1fr 1fr;

    list-style: none;

    gap: 15px;

    height: 100%;

    a {
      display: flex;
      justify-content: center;
      align-items: center;

      text-decoration: none;

      font-weight: 400;

      color: #666;

      padding-top: 2px;
      border-bottom: 2px solid transparent;

      transition: 0.2s border-bottom;

      padding: 8px 6px;

      height: 100%;

      li {
        margin-left: 4px;
      }

      :hover {
        border-bottom: 2px solid #0091ce;
      }
    }
  }
`;

export const Actions = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;

  margin-right: 25px;

  button {
    display: flex;
    justify-content: center;
    align-items: center;

    background: none;
    border: none;

    cursor: pointer;

    padding: 8px;

    transition: 0.2s background;

    border-radius: 4px;

    :hover {
      background: #f3f3f3;
    }
  }
`;