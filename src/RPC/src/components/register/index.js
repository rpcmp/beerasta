import React from 'react';
import './index.scss';

import Form from './form/Form';

function Register(props) {
   return (
    <div className="register">
        <Form history={props.history}/>
    </div>
   );
}

export default Register;