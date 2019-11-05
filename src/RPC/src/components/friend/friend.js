import React from 'react';
import './friends.scss';
import Userpic from './img/userpic.png';

class Friend extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="friend">
                <h3 className="name">{this.props.username}</h3>
                <img className="userpic" src={Userpic} alt="userpic"></img>
                <button className="btn">Написать</button>
            </div>
        );
    }
}

export default Friend;