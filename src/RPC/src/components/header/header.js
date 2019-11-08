import React from 'react';
import './Header.scss';
import Logo from './img/logo.png';
import {NavLink} from "react-router-dom"

function Header() {
    return (
        <div className="header">
            <img className="header__img" src={Logo} alt="logo"></img>
            <div className="menu header__menu">
                <NavLink exact to="/" className="menu__item">Новости</NavLink>
                <NavLink to="/feasts" className="menu__item">Пиры</NavLink>
                <NavLink to="/friends" className="menu__item">Братья</NavLink>
                <NavLink to="/evangelie" className="menu__item">Писание</NavLink>
                <NavLink to="/user" className="menu__item">Профиль</NavLink>
                <NavLink to="/login" className="menu__item">Войти</NavLink>
            </div>
        </div>
    );
}

export default Header;