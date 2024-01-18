import axios from "axios";
import { useEffect } from "react";
import { useCookies } from "react-cookie";
import { useNavigate } from "react-router-dom";

function KakaoRedirect() {
  const code = new URL(window.location.href).searchParams.get("code"); 
  const [cookies, setCookie] = useCookies();
  const navigate = useNavigate();

  useEffect(() => {
    async function KakaoLogin() {
      const res = await axios.post(
        process.env.REACT_APP_API +
          `/auth/member/login/kakao?code=${code}`
      );
      const { access_token, refresh_token} = res.data;
      setCookie("accessToken", access_token);
      setCookie("refreshToken", refresh_token);
      setCookie("sns","KAKAO");
      navigate("/Success", { replace: true })
    };
    KakaoLogin();
  }, []);
 
 
  return (
    <div>
      로딩중
    </div>
  );
}


export default KakaoRedirect;