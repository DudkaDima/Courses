import React from 'react';

import './App.css'
import store from './classComponent/store'
import { createTheme, ThemeProvider } from '@mui/material/styles';
import Button from '@mui/material/Button';
import { connect } from 'react-redux';
import examplesAntions  from "./actions/examplesCalc"
import reducerCalc from "./reducers/reducer"
import TextareaAutosize from '@mui/base/TextareaAutosize';


const theme = createTheme({
  status: {
    danger: '#e53e3e',
  },
  palette: {
    primary: {
      main: '#0971f1',
      darker: '#053e85',
    },
    neutral: {
      main: "#FF8C00",
      contrastText: '#fff',
    },
  },
});




class App extends React.Component {

  constructor() {
    super();
    


    this.state = {
      out: '0',
      history : ' ',
      countOfSign : 0,
      lastSign : "no",
      preProps : ' '
      
    }

    this.refOutput = React.createRef();
    this.refCountOfSign = React.createRef();
   
  };


  findCountOfSign() {
    let output = this.refOutput.current;
    let signs = output.value.replace(/[^\+\-\/\*]/g, '');
    return parseInt(signs);
  }

  getTwoNumbersAndSign() {
    let output = this.refOutput.current;
    let arrOfNumbers = output.value.split(/[-+*/]/g);
    
    return arrOfNumbers;
  }

  calculateMathExamples(example) {
    
      let output = example;  
      let pattern = /[\+\-\*\/]/;
      let regularEx = new RegExp(pattern,'');
      let sign = output.charAt(parseInt(output.search(regularEx)));
      let numbers = output.split(/[-+*/]/g);
      let firstNumber = numbers[0];
      let secondNumber = numbers[1]; 
      let result = 0;
      switch (sign) {
        case '+': {
         
            result = (parseInt(firstNumber) + parseInt(secondNumber));
            console.log(result)
            return result
            
        }
        case '-': {
            result = (parseInt(firstNumber) - parseInt(secondNumber));
            return result
        }
        case '/': {
          result = (parseInt(firstNumber) / parseInt(secondNumber));
          return result
        }
        case '*': {
          result = (parseInt(firstNumber) * parseInt(secondNumber));
    
          return result
          
        }
        
      }
  
  }

  calculate() {
    let output = this.refOutput.current;
    let pattern = /[\+\-\*\/]/;
    let regularEx = new RegExp(pattern,'');
    let sign = output.value.charAt(parseInt(output.value.search(regularEx)));
    let numbers = this.getTwoNumbersAndSign();
    let firstNumber = numbers[0];
    let secondNumber = numbers[1]; 
    let result = 0;
    switch (sign) {
      case '+': {
    
          result = (parseInt(firstNumber) + parseInt(secondNumber));
          return result;
          
      }
      case '-': {
          result = (parseInt(firstNumber) - parseInt(secondNumber));
          return result;
      }
      case '/': {
        result = (parseInt(firstNumber) / parseInt(secondNumber));
        return result;
      }
      case '*': {
        result = (parseInt(firstNumber) * parseInt(secondNumber));
        return result;
      }
      
    }
    
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
   
    const {
        list,
    } = this.props;
    let newState;
  
    let result = "";
    if (prevProps.list !== list) {
     
     
        let i = 0;
        do {
          result += list[i] + " = " + this.calculateMathExamples(list[i]) + "\n.............\n"
            i++;
           
        } while (i < list.length);
        this.setState({
          history : this.state.history += result
        });
    }
   
    console.log(result)
    console.log(this.props.list)
    
    
}
  
  tapeNumber(value) {
    
    let output = this.refOutput.current
    let currentValue = value;

    if(output.value === '0') {
      output.value = ''
    }

    let signs = this.findCountOfSign();
    
    if(value === '+' || value === '-' || value === '*' ||value === '/') { 
      this.state.countOfSign += 1;

      if(this.state.lastSign != "no" && this.state.countOfSign === 1) {
        
          this.state.out = value; 
          output.value = output.value.replace(output.value.charAt(output.value.length-1),  this.state.out)
         
          this.state.lastSign = currentValue;
          this.state.countOfSign = 1;
      } else if(this.state.lastSign === "no" && this.state.countOfSign === 2) {
        
        this.setState({
          history : this.state.history += output.value + "=" + this.calculate() + "\n............\n"
        }) 
      
        output.value = this.calculate() + "+";  
        this.setState({
          countOfSign : 1
        }) 
      }
       else {
        output.value += currentValue
        this.state.lastSign = currentValue
      }
    } else {
      this.state.lastSign = "no";
      output.value += currentValue
    
    }
  }
  
 
  tapeOperation(value) {
    let output = this.refOutput.current;
    
    if(value === 'CE') {
      output.value = output.value.substring(0, output.value.length - 1)
      if(output.value.length === 0) {output.value = '0'}
    } else if(value === 'C') {
      output.value = '0'
    } else if(value === '=') {
      
      this.setState({
        history : this.state.history += output.value + "=" + this.calculate() + "\n............\n"

      }) 
      this.setState({
        countOfSign : 0
      }) 
      output.value = this.calculate();  
      
    } 

  }

  render() {


  const {
      numbersClick,
      operationsClick,
      isLoading,
      isError,
      dispatch
  } = this.props;
    return(
    
          <div className="container">
        <div className="output"> 

        
       
          <TextareaAutosize
                        maxRows={4}
                        readOnly
                        value={this.state.history}
                        label = "History"
                    />
      
        
        <input ref={this.refOutput} type="text" defaultValue={this.state.out}></input>
        </div>
        
        <div className="button">
        <ThemeProvider theme={theme}>
        {store.buttons.map(item => 
             <Button variant="contained" size="small" color="neutral"
             onClick={() => this.tapeNumber(item.val)}>{item.val}
             </Button>)}

        {store.operations.map(item =>
         <Button
             variant="contained" size="small" color="neutral"
                onClick={()=> this.tapeOperation(item.val)}>
                  {item.val}
          </Button>)}
                
                  <Button onClick={() => examplesAntions.fetchExamples({
                    mathCount : 5,})(dispatch)}>
                      Get Examples
                      </Button>
        </ThemeProvider>
          
        
        </div>
      </div>
     
    
    )
  }
}

const mapReduxStatetoProps = reduxState => ({
  ...reduxState,
});

const mapDispatchToProps = dispatch => ({
  dispatch,
});

export default connect(mapReduxStatetoProps, mapDispatchToProps) (App);
