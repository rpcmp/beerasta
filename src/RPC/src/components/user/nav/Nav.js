import React from 'react';
import './Nav.scss';

// Общее, приватность, уведомления
function Nav() {
    return (
        <div className="nav">
            <button disabled className="nav__btn nav-btn-active">
                Аккаунт
            </button>
            <button className="nav__btn">
                Приватность
            </button>
            <button className="nav__btn nav__btn-last">
                Уведомления
            </button>
        </div>
    );
}

export default Nav;