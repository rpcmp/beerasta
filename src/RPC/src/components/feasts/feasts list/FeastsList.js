import React, { useState, useEffect } from 'react';
import './FeastsList.scss';

import Feast from './feast/Feast';

function FeastsList(props) {
    const [items, setItems] = useState([])

    useEffect(() => {
        if (localStorage.getItem("user") == null) {
            window.location = "/#/login";
        } else {
            fetch(`https://beerasta.herokuapp.com/item/list?username=${localStorage.getItem("user")}`)
                .then(res => {
                    if (res.ok) {
                        return res.json()
                    }
                }).then(com => {
                    setItems(com)
                })
        }
    }, []);

    return (
        <div className="items">
            {
                items.map((val, num) => {
                    return <Feast key={val.id} {...val} />
                })
            }
        </div>
    );
}

export default FeastsList;