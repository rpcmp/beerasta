import React from 'react';
import {HashRouter, Route} from "react-router-dom";
import Header from './components/header/header';
import Login from './components/account/login/login';
import Register from './components/account/register/register';
import User from './components/account/user/user';
import Beer from './components/beer/beer';
import Friends from './components/friend/friends';
import Doctrine from './components/doctrine/doctrine';
import Main from './components/main/main';
import Messages from './components/messages/messages';

function App() {
  return (
    <HashRouter>
      <div className="App">
        <Header/>
        <Route exact path='/' component={Main}/>
        <Route path="/beer" component={Beer}/>
        <Route path="/login" component={Login}/>
        <Route path="/register" component={Register}/>
        <Route path="/user" component={User}/>
        <Route path="/friends" component={Friends}/>
        <Route path="/evangelie" component={Doctrine}/>
        <Route path="/messages" component={Messages}/>
      </div>
      
    </HashRouter>
  );
}

export default App;
