import React from 'react';
import './Evangelie.scss';
import ChapterStyle from './chapter/Chapter.module.scss';

import Search from './search/Search';
import Chapter from './chapter/Chapter';
import Data from './Data.json';

class Evangelie extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            chapters: Data
        };

        this.search = this.search.bind(this);
    }

    render() {
        return (
            <div className="doctrine">
                <Search search={this.search} />
                {this.state.chapters.map((chapter, index) => {
                    return <Chapter
                        key={index}
                        title={chapter.title}
                        text={chapter.text}
                    />
                })}
            </div>
        );
    }

    search(text) {
        if (text === "") {
            this.setState({ chapters: Data });
        } else {
            let items = Data.map((item) => {
                return {
                    title: item.title,
                    text: item.text.replace(text, (str) =>
                        <p class={ChapterStyle.search_text}>{str}</p>
                    )
                }
            });

            console.log(items);

            this.setState({ chapters: items });

            console.log(this.state.chapters);
        }
    }
}

export default Evangelie;