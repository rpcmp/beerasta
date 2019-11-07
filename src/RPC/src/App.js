import React from 'react';
import {HashRouter, Route} from "react-router-dom";
import Header from './components/header/Header';
import Login from './components/login/index';
import Register from './components/register/index';
import User from './components/user/index';
import Beer from './components/feasts/Feasts';
import Friends from './components/friends/Friends';
import Evangelie from './components/evangelie/Evangelie';
// import Main from './components/main/main';
// import Messages from './components/messages/messages';

function App() {
  return (
    <HashRouter>
      <div className="App">
        <Header/>
        {/* {<Route exact path='/' component={Main}/> */}
        <Route path="/feasts" component={Beer}/>
        <Route path="/login" component={Login}/>
        <Route path="/register" component={Register}/>
        <Route path="/user" component={User}/>
        <Route path="/friends" component={Friends}/> 
        <Route path="/evangelie" component={Evangelie}/>
        {/* <Route path="/messages" component={Messages}/> */}
      </div>
      
    </HashRouter>
  );
}

export default App;
