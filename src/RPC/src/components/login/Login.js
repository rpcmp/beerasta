import React from 'react';
import Styles from './Login.module.scss';

import Form from './form/Form';


function Login(props) {
    return (
        <div className={Styles.login}>
            <Form history={props.history}/>
        </div>
    );
}

export default Login;