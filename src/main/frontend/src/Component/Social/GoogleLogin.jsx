import styled from "styled-components";
import googlelogin from "../../assets/googlelogin.png";
function GoogleLogin() {
  const KAKAO_URI = `https://accounts.google.com/o/oauth2/v2/auth?client_id=${process.env.REACT_APP_GOOGLE_CLIENT_ID}&redirect_uri=${process.env.REACT_APP_GOOGLE_REDIRECT_URI}&response_type=code&scope=email profile`;

  return (
    <a href={KAKAO_URI}>
      <GoogleLoginBtn src={googlelogin} alt="googlelogin"></GoogleLoginBtn>
    </a>
  );
}

const GoogleLoginBtn = styled.img`
  width: 250px;
  height: 70px;
`;
export default GoogleLogin;