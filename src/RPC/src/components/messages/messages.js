import React from 'react';
import './messages.scss';

class Messages extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            address: "",
            text: ""
        };
    }

    render() {
        return (
            <div className="messages">
                <div className="new-message">
                    <input className="msg-address" placeholder="Кому" onInput={(e => this.setAddress(e.target.value))}></input>
                    <input className="msg-text" placeholder="Текст" onInput={(e => this.setText(e.target.value))}></input>
                    <button className="btn" onClick={this.sendMessage}>Отправить</button>
                </div>
                <div className="message-container">
                    <div className="message">
                        
                    </div>
                </div>
            </div>
        )
    }

    setAddress(addr) {
        this.setState({ address: addr });
    }

    setText(msg) {
        this.setState({ text: msg });
    }

    sendMessage() {
        let messages = localStorage.getItem("messages");

        if (messages === undefined) {
            messages = [];

        }

        messages[this.state.address].push(this.state.text);
        localStorage.setItem("messages", messages);
    }
}

export default Messages;