import React from 'react';
import './main.scss';
import Hello from './img/hello.png';

function Main(){
    return (
        <div className="main-page">
            <div className="text-container">
                <img className="hello-img" src={Hello} alt="hello-img"></img>
                <p className="text">Приветствую тебя на нашем сайте!<br/>Располагайся поудобнее и изучи доступные разделы.</p>
            </div>
        </div>
    );
}

export default Main;