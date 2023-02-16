import React from 'react';
import { applyMiddleware, createStore, combineReducers } from 'redux';
import { Provider } from 'react-redux';
import thunkMiddleware from 'redux-thunk';

import App from './containers/App.jsx';
import usersReducer from './reducers/user';
import reducer from 'pages/userList/reducers/reducer';
import getUserReducer from 'pages/UpdateUser/reducer/reducer'

const rootReducer = combineReducers({
  user: usersReducer,
  userList : reducer,
  userById: getUserReducer
});

const store = createStore(
  rootReducer,
  applyMiddleware(thunkMiddleware),
);

export default () => (
  <Provider store={store} >
    <App />
  </Provider>
)
