import GoogleLogin from "../Component/Social/GoogleLogin";
import KakaoLogin from "../Component/Social/KakaoLogin";
import NaverLogin from "../Component/Social/NaverLogin";
function Home(){
    return(
        <div>
            Home
            <NaverLogin/>
            <KakaoLogin/>
            <GoogleLogin/>
        </div>
    )
}
export default Home;