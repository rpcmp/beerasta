import React from 'react';
import './friends.scss';
import Hello from './img/hello.png';
import Friend from './friend';
import Item from '../beer/main/item';

class Friends extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            bookedItems: []
        }

        // this.state = {
        //     users: localStorage.getItem("users")
        // };
    }

    componentDidMount() {
        if (localStorage.getItem("user") == null) {
           this.props.history.push("/login");
        } else {
            fetch(`https://beerasta.herokuapp.com/user/booked?username=${localStorage.getItem("user")}`)
                .then(res => {
                    return res.json()
                })
                .then(com => {
                    console.log(com)
                    this.setState({
                        bookedItems: com
                    })
                })
        }
    }

    render() {
        return (
            <div className="friends">
                <div class="current-user">
                    <img className="userpic" src={Hello} alt="userpic"></img>
                    <div className="info">
                        <h4 className="name">
                            Приветствую тебя, {localStorage.getItem("user")}.<br />Здесь ты можешь найти себе новых друзей.
                        </h4>
                    </div>
                </div>
                <div className="all-users">
                    {/* <Friend username="Test"/> */}

                </div>
                <div className="items">
                    {
                        this.state.bookedItems.map(val => {
                            return <Item key={val.id} {...val} />
                        })
                    }
                </div>
            </div>
        );
    }
}

export default Friends;