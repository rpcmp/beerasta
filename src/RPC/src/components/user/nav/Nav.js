import React from 'react';
import Styles from './Nav.module.scss';

function Nav() {
    return (
        <div className={Styles.nav}>
            <button disabled className={Styles.btn}>Аккаунт</button>
            <button className={Styles.btn}>Приватность</button>
            <button className={Styles.btn_last}>Уведомления</button>
        </div>
    );
}

export default Nav;