import axios from "axios";
import { useEffect,useState } from "react";
import { useCookies} from "react-cookie";
import { useNavigate } from "react-router-dom";
function Success(){
    const [cookies,removeCookie] = useCookies(["accessToken", "state"]);
   const [res, setRes] = useState({});
   const { accessToken, sns } = cookies;
   const navigate = useNavigate();
    useEffect(() => {
       async function SessionNaver() {
                try {
                    const response = await axios.post(
                        process.env.REACT_APP_API +
                        `/auth/member/login/naver/Access`,
                        {},
                        {
                            headers: { 
                                Authorization: `Bearer ${accessToken}`,
                            }
                        }
                      );
                      setRes(response.data);
                    } catch (error) {
                      console.error("Error sending data to the server:", error);
                      // 에러 처리
                    }
        }

          async function SessionKakao() {
                        try {
                            const response = await axios.post(
                                process.env.REACT_APP_API +
                                `/auth/member/login/kakao/Access`,
                                {},
                                {
                                    headers: {
                                        Authorization: `Bearer ${accessToken}`,
                                    }
                                }
                              );
                              setRes(response.data);
                            } catch (error) {
                              console.error("Error sending data to the server:", error);
                              // 에러 처리
                            }
                }

          async function SessionGoogle() {
                        try {
                            const response = await axios.post(
                            process.env.REACT_APP_API +
                            `/auth/member/login/Google/Access`,
                            {},
                            {
                                headers: {
                                      Authorization: `Bearer ${accessToken}`,
                                }
                            }
                            );
                             setRes(response.data);
                             } catch (error) {
                               console.error("Error sending data to the server:", error);
                             }
                        }
        
                if(accessToken&&sns) {
                    if(sns=='NAVER'){
                      SessionNaver();
                    }
                    if(sns=='KAKAO'){
                      SessionKakao();
                    }
                    if(sns=='GOOGLE'){
                      SessionGoogle();
                    }
                }
        
            
    },[]);
    
    async function logout(){
      if(sns=='KAKAO'){
        try {
          const response = await axios.post(
              `https://kapi.kakao.com/v1/user/logout`,
              {},
              {
                  headers: {
                    Authorization: `Bearer ${accessToken}`,
                  }
              }
            );
         
              removeCookie("accessToken",{ path: '/', expires: new Date(0) });
              removeCookie("refreshToken",{ path: '/', expires: new Date(0) });
              removeCookie("sns",{ path: '/', expires: new Date(0) });
              navigate("/", { replace: true });
           
          } catch (error) {
            console.error("Error sending data to the server:", error);
            // 에러 처리
          }
      }
      if(sns=='NAVER'){
        removeCookie("accessToken",{ path: '/', expires: new Date(0) });
        removeCookie("refreshToken",{ path: '/', expires: new Date(0) });
        removeCookie("sns",{ path: '/', expires: new Date(0) });
        removeCookie("state",{ path: '/', expires: new Date(0) });
        navigate("/", { replace: true });
      }
      if(sns=='GOOGLE'){
       removeCookie("accessToken",{ path: '/', expires: new Date(0) });
       removeCookie("refreshToken",{ path: '/', expires: new Date(0) });
       removeCookie("sns",{ path: '/', expires: new Date(0) });
       navigate("/", { replace: true });
      }
    }
     return (
       <div>
        <button onClick={logout}>logout</button>
         <h1>Welcome, {res.nickname}!</h1>

         {/* 다른 속성들에 대한 출력 */}
         <pre>{JSON.stringify(res, null, 2)}</pre>
         {/* JSON.stringify를 사용하여 객체 전체를 문자열로 변환하여 출력 */}
       </div>
     );
}
export default Success;