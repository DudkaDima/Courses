const initialState = {
    isLoading: false,
    userlist: [],
    name: "Users",
  };
  export default (state = initialState, action) => {  
    switch (action.type) {
      case 'REQUEST_USERS': {
        return {
          ...state,
          isLoading: true,
        };
      }
      case 'RECEIVE_USERS': {
        const {
          users,
        } = action;
        return {
          ...state,
          isLoading: false,
          userlist: users,
        };
      }
      default: return state;
    }
  };