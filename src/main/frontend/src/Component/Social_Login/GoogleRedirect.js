import axios from "axios";
import { useEffect } from "react";
import { useCookies } from "react-cookie";
import { useNavigate } from "react-router-dom";

function GoogleRedirect() {
  const code = new URL(window.location.href).searchParams.get("code"); 
  const [cookies, setCookie] = useCookies();
  const navigate = useNavigate();

   useEffect(() => {
     async function GoogleLogin() {
       const res = await axios.post(
         process.env.REACT_APP_API +
           `/auth/member/login/google?code=${code}`
       );
       const { access_token} = res.data;
       setCookie("accessToken", access_token);
       setCookie("refreshToken", "X");
       setCookie("sns","GOOGLE");
       navigate("/Success", { replace: true })
     };
     GoogleLogin();
   }, []);
 
 
  return (
    <div>
      로딩중
    </div>
  );
}


export default GoogleRedirect;