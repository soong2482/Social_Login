import styled from "styled-components";
import naverlogin from "../../assets/naverlogin.png";
function NaverLogin() {
  const NAVER_URI = `https://nid.naver.com/oauth2.0/authorize?client_id=${process.env.REACT_APP_NAVER_CLIENT_ID}&response_type=code&redirect_uri=${process.env.REACT_APP_NAVER_REDIRECT_URI}&state=${process.env.REACT_APP_NAVER_STATE}`;

  return (
    <a href={NAVER_URI}>
      <NaverLoginBtn src={naverlogin} alt="naverlogin"></NaverLoginBtn>
    </a>
  );
}

const NaverLoginBtn = styled.img`
width: 250px;
height: 70px;
`;
export default NaverLogin;