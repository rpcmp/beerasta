import React from 'react';
import './user.scss';
import Userpic from './img/userpic.png';

class User extends React.Component {
    constructor(props) {
        super(props);
        this.exit = this.exit.bind(this);
    }

    render() {
        return (<>
                <div className="user">
                    <img className="userpic" src={Userpic} alt="userpic"></img>

                    <p>Приветствую тебя, о просвященный {localStorage.getItem("user")}</p>
                    <p>Присаживайся поудобнее и отведай вкусной лапши во славу макаронного монстра!</p>
                    <button className="btn" onClick={this.exit}>Выйти</button>
                </div>
            </>
        );
    }

    exit() {
        fetch("/logout", {
            method: 'POST'
        }).then(res => {
            console.log("logout")
            if (res.ok) {
                localStorage.removeItem("user");
                this.props.history.push("/login");
            }
        })
    }
}

export default User;