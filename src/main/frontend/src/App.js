
import './App.css';
import React from 'react';
import Home from './Pages/Home.jsx';
import { Route, Routes } from 'react-router-dom';
import NaverRedirect from './Component/Social_Login/NaverRedirect.js';
import KakaoRedirect from './Component/Social_Login/KakaoRedirect.js';
import GoogleRedirect from './Component/Social_Login/GoogleRedirect.js';
import Success from './Pages/Success.jsx';
function App() {
  return (
   <Routes>
       <Route path='/' element={<Home />} />
       <Route path='/authNaver' element={<NaverRedirect/>}/>
       <Route path='/authKakao' element={<KakaoRedirect/>}/>
       <Route path='/authGoogle' element={<GoogleRedirect/>}/>
       <Route path='/Success' element={<Success/>}/>
   </Routes>
  );
}

export default App;
