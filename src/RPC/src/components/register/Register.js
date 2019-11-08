import React from 'react';
import Styles from './Register.module.scss';

import Form from './form/Form';

function Register(props) {
   return (
    <div className={Styles.register}>
        <Form history={props.history}/>
    </div>
   );
}

export default Register;