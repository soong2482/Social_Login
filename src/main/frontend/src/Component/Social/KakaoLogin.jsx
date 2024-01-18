import styled from "styled-components";
import Kakaologin from "../../assets/kakaologin.png";
function KakaoLogin() {
  const KAKAO_URI = `https://kauth.kakao.com/oauth/authorize?client_id=${process.env.REACT_APP_KAKAO_CLIENT_ID}&redirect_uri=${process.env.REACT_APP_KAKAO_REDIRECT_URI}&response_type=code`;

  return (
    <a href={KAKAO_URI}>
      <KakaoLoginBtn src={Kakaologin} alt="kakaologin"></KakaoLoginBtn>
    </a>
  );
}

const KakaoLoginBtn = styled.img`
width: 250px;
height: 70px;
`;
export default KakaoLogin;