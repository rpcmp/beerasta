import React from 'react';
import Styles from './Chapter.module.scss';

class Chapter extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            tityleStyle: {
                backgroundColor: "white"
            },
            textStyle: {
                display: "none"
            }
        };

        this.showText = this.showText.bind(this);
    }

    render() {
        return (
            <div className={Styles.chapter}>
                <button className={Styles.chapter__title} style={this.state.tityleStyle} onClick={this.showText}>{this.props.title}</button>
                <p className={Styles.chapter__text} style={this.state.textStyle}>{this.props.text}</p>
            </div>
        );
    }

    showText() {
        if (this.state.textStyle.display === "block") {
            this.setState({
                tityleStyle: { backgroundColor: "white" },
                textStyle: { display: "none" }
            });
        } else {
            this.setState({
                tityleStyle: { backgroundColor: "#FFD400" },
                textStyle: { display: "block" }
            });
        }
    }
}

export default Chapter;