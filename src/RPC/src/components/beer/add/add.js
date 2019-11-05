import React from 'react';
import './add.scss';

class Add extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            address: "",
            min: 0,
            max: 0,
            time: ""
        }

        this.setAddress = this.setAddress.bind(this)
        this.setMin = this.setMin.bind(this)
        this.setMax = this.setMax.bind(this)
        this.setTime = this.setTime.bind(this)
        this.sendItem = this.sendItem.bind(this)
    }

    setAddress(address){
        this.setState({address: address})
    }

    setMin(min){
        this.setState({min: min})
    }

    setMax(max){
        this.setState({max: max})
    }

    setTime(time){
        this.setState({time: time})
    }

    // https://beerasta.herokuapp.com/user/personal
    // PUT
    //{address, min, max, time}

    sendItem(){
        let body = JSON.stringify(this.state)
        console.table(this.state)

        fetch("https://beerasta.herokuapp.com/user/personal?username=" + localStorage.getItem("user"), {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: body
        }).then(res => {
            if (res.ok){
                document.location.reload(true)
            }
        })
    }

    render() {
        return (
            <div className="add">
                <h2 className="title">Устроить пирушку</h2>

                <div className="form">
                    <div className="item">
                        <p>Адрес</p>
                        <input className="input input-text" onInput={e => this.setAddress(e.target.value)}></input>
                    </div>
                    <div className="item">
                        <p>Количество человек</p>
                        <div className="half-container">
                            <input className="input input-half" placeholder="Min" type="number" onInput={e => this.setMin(e.target.value)}></input>
                            <input className="input input-half" placeholder="Max" type="number" onInput={e => this.setMax(e.target.value)}></input>
                        </div>

                    </div>
                    <div className="item">
                        <p>Описание</p>
                        <input className="input input-text"></input>
                    </div>
                    <div className="item">
                        <p>Время начала</p>
                        <input type="time" className="input" onInput={e => this.setTime(e.target.value)}></input>
                    </div>
                    <div className="item">
                        <button className="input-submit" onClick={this.sendItem}>Пируем</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default Add;