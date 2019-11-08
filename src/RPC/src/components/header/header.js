import React from 'react';
import Styles from './Header.module.scss';
import Logo from './img/logo.png';
import {NavLink} from "react-router-dom"

function Header() {
    return (
        <div className={Styles.header}>
            <img className={Styles.header__img} src={Logo} alt="logo"></img>
            <div className={Styles.menu}>
                <NavLink exact to="/" className={Styles.menu__item}>Новости</NavLink>
                <NavLink to="/feasts" className={Styles.menu__item}>Пиры</NavLink>
                <NavLink to="/friends" className={Styles.menu__item}>Братья</NavLink>
                <NavLink to="/evangelie" className={Styles.menu__item}>Писание</NavLink>
                <NavLink to="/user" className={Styles.menu__item}>Профиль</NavLink>
                <NavLink to="/login" className={Styles.menu__item}>Войти</NavLink>
            </div>
        </div>
    );
}

export default Header;