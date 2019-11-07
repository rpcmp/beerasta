import React from 'react';
import './index.scss';

import Nav from './nav/Nav';
import Info from './info/Info';

function User() {
    return (
        <div className="user">
            <Nav />
            <Info />
        </div>
    )
}

export default User;