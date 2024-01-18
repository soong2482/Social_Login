import axios from "axios";
import { useEffect } from "react";
import { useCookies } from "react-cookie";
import { useNavigate } from "react-router-dom";

function NaverRedirect() {
  const code = new URL(window.location.href).searchParams.get("code"); 
  const state = new URL(window.location.href).searchParams.get("state"); 
  const [cookies, setCookie] = useCookies();
  const navigate = useNavigate();

  useEffect(() => {
    async function NaverLogin() {
      try {
        const res = await axios.post(
          process.env.REACT_APP_API +
            `/auth/member/login/naver?code=${code}&state=${state}`
        );
         const { access_token, refresh_token} = res.data;

        setCookie("accessToken", access_token);
        setCookie("refreshToken", refresh_token);
        setCookie("state", state);
        setCookie("sns","NAVER");
        navigate("/Success", { replace: true });
      } catch (error) {
        console.error("Error during NaverLogin:", error);
        // Handle error as needed
      }
    }

    NaverLogin();
  }, []);

  return (
    <div>
      로딩중
    </div>
  );
}

export default NaverRedirect;
