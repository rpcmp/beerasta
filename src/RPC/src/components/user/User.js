import React from 'react';
import Styles from './User.module.scss';

import Nav from './nav/Nav';
import Info from './Settings/Settings';

function User() {
    return (
        <div className={Styles.user}>
            <Nav />
            <Info />
        </div>
    )
}

export default User;